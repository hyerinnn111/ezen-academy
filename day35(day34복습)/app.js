const path = require('path');
const express = require('express');
const defaultRoutes = require('./routes/default')
const restaurantRoutes = require('./routes/restaurants')

const port = 3000;
const app  = express();

app.set('views', path.join(__dirname, 'views'))
app.set('view engine', 'ejs')

app.use(express.static('public'));
app.use(express.urlencoded({extended: false}))

app.use('/', defaultRoutes)
app.use('/', restaurantRoutes)

app.get('/', function(req, res) {
    res.render('index')
} )

app.get('/restaurants', function(req, res) {
    const storedRestaurants = resData.getStoredRestaurants();
    res.render('restaurants', {
        numberOfRestaurants: storedRestaurants.length,
        restaurants: storedRestaurants,
    })
})

app.get('/restaurants/:id', function(req, res) {
    const restaurantId = req.params.id;
    const storedRestaurants = resData.getStoredRestaurants();
    for (const restaurant of storedRestaurants) {
        if (restaurant.id === restaurantId) {
            res.render('restaurant-detail', {restaurant: restaurant})
        }
    }
    res.render('404')
})

app.get('/recommend', function(req, res) {
    res.render('recommend')
})

app.post('/recommend', function(req, res) {
    const restaurant = req.body;
    restaurant.id = uuid.v4();
    const storedRestaurants=resData.getStoredRestaurants();
    storedRestaurants.push(restaurant);
    resData.storedRestaurants(storedRestaurants)
    res.rendirect('/confirm')
})

app.get('/confirm', function(req, res) {
    res.render('confirm')
})

app.get('/about', function(req, res) {
    res.render('about')
})

app.use(function(req, res) {
    res.render('404')
})

app.use(function(error, req, res, next) {
    res.render('500')
})

app.listen(port, () => console.log(`${port}번으로 서버구동`))