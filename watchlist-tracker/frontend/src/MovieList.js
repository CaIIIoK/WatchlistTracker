import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class MovieList extends Component {

    constructor(props) {
        super(props);
        this.state = {movies: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/movies')
            .then(response => response.json())
            .then(data => this.setState({movies: data}));
    }

    async remove(id) {
        await fetch(`/movies/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedMovies = [...this.state.movies].filter(i => i.id !== id);
            this.setState({movies: updatedMovies});
        });
    }

    render() {
        const {movies} = this.state;

        const showList = movies.map(movie => {
            return <tr key={movie.id}>
                <td style={{whiteSpace: 'nowrap'}}>{movie.title}</td>
                <td>{movie.genre}</td>
                <td>{movie.releaseYear}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/movies/" + movie.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(movie.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/movies/new">Add Movie</Button>
                    </div>
                    <h3>Movies</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Title</th>
                            <th width="60%">Genre</th>
                            <th width="10%">Year</th>
                        </tr>
                        </thead>
                        <tbody>
                        {showList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default MovieList;