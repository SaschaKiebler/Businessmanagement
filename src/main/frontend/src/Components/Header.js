
import React from "react";
import Navbar from 'react-bootstrap/Navbar';
import {Nav} from "react-bootstrap";
import {Container} from "react-bootstrap";
import {NavDropdown} from "react-bootstrap";

function Header (){
        return (<div>

            <Navbar bg="light" expand="lg">
                <Container>
                    <Navbar.Brand href="#home">BMS</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link href="#home">Home</Nav.Link>
                            <Nav.Link href="#link">Link</Nav.Link>
                            <NavDropdown title="Aufträge" id="basic-nav-dropdown">
                                <NavDropdown.Item href="#action/3.1">Aufträge Ansehen</NavDropdown.Item>
                                <NavDropdown.Item href="#action/3.2">Neuen Auftrag hinzufügen</NavDropdown.Item>
                                <NavDropdown.Divider />
                                <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
                            </NavDropdown>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>

        </div>)

}

export default Header;