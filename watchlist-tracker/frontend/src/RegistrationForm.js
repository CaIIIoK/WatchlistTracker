import React, { Component } from 'react';

class RegistrationForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      email: '',
      password: '',
      confirmPassword: ''
    };
  }

  handleSubmit = (event) => {
    event.preventDefault();
    // add logic for handling registration
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
      <form onSubmit={this.handleSubmit}>
        <div>
          <label>Email:</label>
          <input type="email" name="email" value={this.state.email} onChange={this.handleInputChange} required />
        </div>
        <div>
          <label>Password:</label>
          <input type="password" name="password" value={this.state.password} onChange={this.handleInputChange} required />
        </div>
        <div>
          <label>Confirm Password:</label>
          <input type="password" name="confirmPassword" value={this.state.confirmPassword} onChange={this.handleInputChange} required />
        </div>
        <button type="submit">Register</button>
      </form>
    );
  }
}

export default RegistrationForm;