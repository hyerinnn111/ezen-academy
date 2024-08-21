const express = require('express');

// sql로그인 정보가 들은 파일을 불러옵니다
const db = require('../data/database');

const router = express.Router();

router.get('/', function(req, res) {
    res.redirect('/posts');
})

router.get('/posts', async function(req, res) {
  const query = `select posts.*, authors.name as author_name
  from posts
  inner join authors
  on posts.author_id = authors.id`;
  const [posts] = await db.query(query)
  res.render('posts-list', {posts: posts})
  });
// 읽어온 sql정보를 가지고 쿼리를 돌려서 db안 데이터를 보입니다
router.get('/new-post', async function(req, res) {
 //db 변수에 저장된 sql 로그인 정보를 가지고
 // sql db에 들가서 쿼리문을 날린 뒤에 받은 데이터를 authors라는 이름으로 
 // 프론트엔드 페이지에 넘깁니다
    const [authors] = await db.query('select * from authors');
    res.render('create-post', {authors: authors});
})

// 메인페이지에 내가 작성한 컨텐츠를 화면에 표시하고싶다
// sql 데이터 베이스에서 작성한 글을 불러온다
router.post('/posts', async function (req, res) {
  // 지금 데이터는 배열입니다 (key와 value 구성이 아닌 데이터값만을 불렀음)
  // 내가 표시할 데이터의 목록을 data변수에 정의하였습니다
  const data = [
    req.body.title,
    req.body.summary,
    req.body.content,
    req.body.author,
  ]
  // db변수에 저장된 로그인 정보로 sql에 접근하여 데이터 삽입 쿼리문을 실행합니다
  // 데이터 삽입 쿼리문을 실행합니다
  // ? 의 의미는 직접 입력이 아닌 지정한 변수 안의 데이터로 갈음하겠다
  // 폼태그의 입력데이터를 data변수에 배열로 저장해서 쿼리문으로 sql에 집어넣는다
  // 물음표 개수와 콤마개수가 같아야한다
  await db.query('insert into posts (title, summary, body, author_id) values (?)',[data,])
  res.redirect('/posts');
})

router.get("/posts/:id", async function (req, res) {
  const query = `select posts.*, authors.name as author_name, 
      authors.email as author_email 
      from posts
      inner join authors 
      on posts.author_id = authors.id
      where posts.id = ?`;

  const [posts] = await db.query(query, [req.params.id]);

  if (!posts || posts.length === 0) {
    return res.status(404).render(404);
  }

  const postData = {
    ...posts[0],
    date: posts[0].date.toISOString(),
    humanReadableDate: posts[0].date.toLocaleDateString("en-US", {
      weekday: "long",
      year: "numeric",
      month: "long",
      day: "numeric",
    }),
  };

  res.render("post-detail", { post: postData });
});

// 생성된 게시글 세부주소에 가서 데이터를 조회하는 쿼리문을 보낸다
router.get('/posts/:id/edit', async function(req, res) {
  const query = `select * from posts where id = ?`;
// post변수엔 반드시 배열[]처리 해야함
// 게시글 데이터는 sql에서 여러줄이 있기 때문
  const [posts] = await db.query(query, [req.params.id])
  // 게시글 데이터가 없는경우 예외처리
  if (!posts || posts.length ===0) {
    return res.status(404).render(404);
  }
  // 데이터가 정상으로 들어왔다면 화면에 표시한다
  res.render('update-post', {post: posts[0]})
})

// 조회된 데이터를 수정한다 값을 받아서
// sql 데이터 변경 쿼리문으로 sql 데이터를 수정한다
router.post('/posts/:id/edit', async function(req,res) {
const query = `
update posts set title = ? summary = ? body = ? where id = ?`

await db.query(query, [
  req.body.title,
  req.body.summary,
  req.body.content,
  req.params.id,
])
// 데이터 변경이 끝나면 원래페이지 이동
res.redirect('/posts');
})

// 데이터의 삭제(뭔가를 추가하고 읽으면 get을 쓰고 뭔가를 바꾸는 뉘앙스는 post를 쓴다)
router.post(`/posts/:id/delete`, async function(req, res) {
  await db.query(`delete from posts where id = ?`, [req.params.id])
  res.redirect('/posts');

})

module.exports = router;
