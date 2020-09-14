import { MockRequest } from '@delon/mock';

let list: any[] = [];
const total = 20;

for (let i = 0; i < total; i += 1) {
  list.push({
    id: i + 1,
    cid: 1,
    isDelete: false,
    description: 'We supply a series of design principles, practical patterns and high quality' +
      ' design resources(Sketch and Axure), to help people create their product prototypes beautifully ' +
      'and efficiently.',
    callNo: Math.floor(Math.random() * 1000),
    rate: Math.floor(Math.random() * 5),
    updatedAt: new Date(`2017-07-${Math.floor(i / 2) + 1}`),
    createdAt: new Date(`2017-07-${Math.floor(i / 2) + 1}`),
    progress: Math.ceil(Math.random() * 10),
    tag: `Tag ${i}`
  });
}

function genData(params: any) {
  let ret = [...list];
  ret = ret.filter(data => !data.isDelete);
  return { total: ret.length, list: ret};
}

function saveData(id: number, value: any) {
  const item = list.find(w => w.id == id);
  if (!item) { return { msg: '无效用户信息' }; }
  list = list.map(record => {
    if (record.id == id) record = Object.assign(item, value);
    return record;
  })
  return { msg: 'ok' };
}
function putData(value: any) {
  value.id = list.length + 1
  value.updatedAt = new Date(),
    list.push(value)
  return { msg: 'ok' };
}

export const SOLUTIONS = {
  '/solution': (req: MockRequest) => genData(req.queryString),
  '/solution/:id': (req: MockRequest) => {
    console.log(req,list)
    return list.find(w => w.id == req.params.id)
  },
  '/solution/:cid/case': (req: MockRequest) => list.filter(w => w.cid == req.params.cid),
  'POST /solution/:id': (req: MockRequest) => saveData(+req.params.id, req.body),
  'PUT /solution': (req: MockRequest) => putData(req.body),
  '/solution/current': {
    id: 1,
    isDelete: false,
    cid: 1,
    description: '这是一段描述',
    callNo: Math.floor(Math.random() * 1000),
    rate: Math.floor(Math.random() * 5),
    updatedAt: new Date(`2017-07-${Math.floor(1 / 2) + 1}`),
    createdAt: new Date(`2017-07-${Math.floor(1 / 2) + 1}`),
    progress: Math.ceil(Math.random() * 10),
    tag: `Tag ${10}`
  }
};
