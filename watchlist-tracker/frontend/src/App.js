import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ClientList from './ClientList';
import ClientEdit from "./ClientEdit";
import TVShowList from './TVShowList';
import TVShowEdit from './TVShowEdit';
import MovieList from './MovieList';
import MovieEdit from './MovieEdit';
import RegisterForm from './RegistrationForm';
import LoginForm from './LoginForm';
import CarouselComponent from './CarouselComponent';

class App extends Component {
  render() {
    return (
        <Router>
          <div className="App">
            
            <Switch>
              <Route path='/' exact={true} component={Home}/>
              <Route path='/clients' exact={true} component={ClientList}/>
              <Route path='/clients/:id' component={ClientEdit}/>
              <Route path='/tvshows' exact={true} component={TVShowList}/>
              <Route path='/tvshows/:id' component={TVShowEdit}/>
              <Route path='/movies' exact={true} component={MovieList}/>
              <Route path='/movies/:id' component={MovieEdit}/>
              <Route path='/register' component={RegisterForm}/>
              <Route path='/login' component={LoginForm}/>           
            </Switch>
            <div className="carousel-container">
              <CarouselComponent />
            </div>
            <footer className="footer">
        <p>Copyright 2023, ORUD Oleksandr Rudyi</p>
      </footer>
          </div>          
        </Router>
    )
  }
}

export default App;