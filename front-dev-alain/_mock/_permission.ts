import { MockRequest } from '@delon/mock';

const list: any[] = [];
const total = 10;

for (let i = 0; i < total; i += 1) {
  list.push({
    id: i + 1,
    isDelete: false,
    title: `permission ${i}`,
    description: '权限',
    callNo: Math.floor(Math.random() * 1000),
    status: Math.floor(Math.random() * 10) % 4,
    updatedAt: new Date(`2017-07-${Math.floor(i / 2) + 1}`),
    createdAt: new Date(`2017-07-${Math.floor(i / 2) + 1}`),
    progress: Math.ceil(Math.random() * 100),
  });
}

function genData(params: any) {
  let ret = [...list];
  ret = ret.filter(data => !data.isDelete);
  return { total: ret.length, list: ret};
}

function saveData(id: number, value: any) {
  const item = list.find(w => w.id === id);
  if (!item) { return { msg: '无效用户信息' }; }
  Object.assign(item, value);
  return { msg: 'ok' };
}
function putData(value: any) {
  value.id = list.length + 1
  value.updatedAt = new Date(),
  list.push(value)
  return { msg: 'ok' };
}

export const PERMISSIONS = {
  '/permission': (req: MockRequest) => genData(req.queryString),
  '/permission/:id': (req: MockRequest) => list.find(w => w.id === +req.params.id),
  'POST /permission/:id': (req: MockRequest) => saveData(+req.params.id, req.body),
  'PUT /permission': (req: MockRequest) => putData(req.body),
  '/permission/current': {
    id: 1,
    isDelete: false,
    title: `permission ${1}`,
    description: '这是一段描述',
    callNo: Math.floor(Math.random() * 1000),
    status: Math.floor(Math.random() * 10) % 4,
    updatedAt: new Date(`2017-07-${Math.floor(1 / 2) + 1}`),
    createdAt: new Date(`2017-07-${Math.floor(1 / 2) + 1}`),
    progress: Math.ceil(Math.random() * 100),
  }
};
