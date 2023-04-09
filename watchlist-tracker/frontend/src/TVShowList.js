import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class TVShowList extends Component {

    constructor(props) {
        super(props);
        this.state = {tvshows: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/tvshows')
            .then(response => response.json())
            .then(data => this.setState({tvshows: data}));
    }

    async remove(id) {
        await fetch(`/tvshows/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedTVShows = [...this.state.tvshows].filter(i => i.id !== id);
            this.setState({tvshows: updatedTVShows});
        });
    }

    render() {
        const {tvshows} = this.state;

        const showList = tvshows.map(show => {
            return <tr key={show.id}>
                <td style={{whiteSpace: 'nowrap'}}>{show.title}</td>
                <td>{show.description}</td>
                <td>{show.releaseYear}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/tvshows/" + show.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(show.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/tvshows/new">Add TV Show</Button>
                    </div>
                    <h3>Shows</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Title</th>
                            <th width="60%">Description</th>
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

export default TVShowList;