import { MockRequest } from '@delon/mock';

const list: any[] = [];
const rpMap: Map<any, any> = new Map<any, any>();
const total = 5;

for (let i = 0; i < total; i += 1) {
  list.push({
    id: i + 1,
    title: `admin ${i}`,
    description: '系统管理员',
    status: Math.floor(Math.random() * 10) % 4,
    updatedAt: new Date(`2017-07-${Math.floor(i / 2) + 1}`),
    createdAt: new Date(`2017-07-${Math.floor(i / 2) + 1}`),
    progress: Math.ceil(Math.random() * 100),
    isDelete: false
  });
}

function permissions(req) {
  console.log(req);
  return rpMap.get(  req.params.id);
}

function addPermission(req) {
  console.log(req);
  rpMap.set(req.params.id, req.body);
}

function genData(params: any) {
  let ret = [...list];
  const pi = +params.pi;
  const ps = +params.ps;
  const start = (pi - 1) * ps;

  if (params.no) {
    ret = ret.filter(data => !data.isDelete);
  }

  return { total: ret.length, list: ret.slice(start, ps * pi) };
}

function saveData(id: number, value: any) {
  const item = list.find(w => w.id === id);
  if (!item) { return { msg: '无效用户信息' }; }
  Object.assign(item, value);
  return { msg: 'ok' };
}

export const ROLES = {
  '/role': (req: MockRequest) => genData(req.queryString),
  '/role/:id': (req: MockRequest) => list.find(w => w.id === +req.params.id),
  'POST /role/:id': (req: MockRequest) => saveData(+req.params.id, req.body),
  '/role/current': {
    id: 1,
    title: `admin ${1}`,
    description: '系统管理员',
    status: Math.floor(Math.random() * 10) % 4,
    updatedAt: new Date(`2017-07-${Math.floor(1 / 2) + 1}`),
    createdAt: new Date(`2017-07-${Math.floor(1 / 2) + 1}`),
    progress: Math.ceil(Math.random() * 100),
    isDelete: false
  },
  '/role/:id/permissions': (req: MockRequest) => permissions(req),
  'POST /role/:id/permissions': (req: MockRequest) => addPermission(req),
};
