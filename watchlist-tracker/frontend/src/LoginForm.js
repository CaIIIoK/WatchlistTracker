import React, { Component } from 'react';
import AppNavbar from './AppNavbar';

class LoginForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      email: '',
      password: ''
    };
  }

  handleSubmit = (event) => {
    event.preventDefault();
    // add logic for handling login
  }

  handleInputChange = (event) => {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
  }

  render() {
    return (
      <div>
        <AppNavbar/>
          <form onSubmit={this.handleSubmit}>
          <div>
            <label>Email:</label>
            <input type="email" name="email" value={this.state.email} onChange={this.handleInputChange} required />
          </div>
          <div>
            <label>Password:</label>
            <input type="password" name="password" value={this.state.password} onChange={this.handleInputChange} required />
          </div>
          <button type="submit">Log in</button>
        </form>
      </div>
    );
  }
}

export default LoginForm;