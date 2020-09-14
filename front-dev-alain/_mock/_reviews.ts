import {MockRequest} from "@delon/mock";

const data = [
  {
    reviewId: '1',
    caseId: '1',
    author: '丁银召',
    avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
    brief: 'asd',
    content:
      `666666666666666666`,
    likes: 100,
    disLikes: 10,
    time: '2020-06-06',
    children: [
      {
        author: '某大神',
        avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
        content:
          '除了会说6，你好会说啥',
        likes: 9,
        disLikes: 99,
        time: '2020-06-06',
      }
    ]
  }
  ,
  {
    reviewId: '2',
    caseId: '1',
    author: '沈士业',
    avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
    brief: 'asd',
    content:
      `期待下一个教程`,
    likes: 100,
    disLikes: 10,
    time: '2020-06-06',
    children: [
      {
        author: '作者本人',
        avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
        content:
          '哈哈',
        likes: 9,
        disLikes: 99,
        time: '2020-06-06',
      }
    ]
  }
];

export const REVIEWS = {
  '/getReview': (req: MockRequest) => {
    return getData(req.queryString.id)
  }
}

function getData(id) {
  console.log(id);
  return data.filter(i => {
    if (i.caseId == id) return i;
  })
}
