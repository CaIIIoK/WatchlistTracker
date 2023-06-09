import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class TVShowEdit extends Component {

    emptyItem = {
        title: '',
        director: '',
        genre: '',
        releaseYear: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const show = await (await fetch(`/movies/${this.props.match.params.id}`)).json();
            this.setState({item: show});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

async handleSubmit(event) {
    event.preventDefault();
    const {item} = this.state;

    await fetch('/movies' + (item.id ? '/' + item.id : ''), {
        method: (item.id) ? 'PUT' : 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item),
    });
    this.props.history.push('/movies');
}

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Show' : 'Add Show'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="name">Title</Label>
                        <Input type="text" name="title" id="title" value={item.title || ''}
                               onChange={this.handleChange} autoComplete="title"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="email">Director</Label>
                        <Input type="text" name="director" id="director" value={item.director || ''}
                               onChange={this.handleChange} autoComplete="director"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="email">Genre</Label>
                        <Input type="text" name="genre" id="genre" value={item.genre || ''}
                               onChange={this.handleChange} autoComplete="genre"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="email">Year</Label>
                        <Input type="number" name="releaseYear" id="releaseYear" value={item.releaseYear}
                               onChange={this.handleChange} autoComplete="releaseYear" placeholder="Year"
                               defaultValue={new Date().getFullYear()} min="1900" max={new Date().getFullYear()}/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/movies">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(TVShowEdit);