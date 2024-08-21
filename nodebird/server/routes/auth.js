// backend/routes/auth.js
const express = require('express');
const passport = require('passport');

const router = express.Router();

router.get('/kakao', passport.authenticate('kakao'));

router.get('/auth/kakao/callback', passport.authenticate('kakao', {
    failureRedirect: '/login'
}), (req, res) => {
    res.redirect(`http://localhost:3000/login-success?userid=${req.user.userid}&username=${req.user.username}&usertype=${req.user.usertype}`);
});

module.exports = router;


