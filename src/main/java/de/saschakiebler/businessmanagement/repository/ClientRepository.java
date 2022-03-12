package de.saschakiebler.businessmanagement.repository;

import de.saschakiebler.businessmanagement.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ClientRepository implements ClientRepoInterface{


    JdbcTemplate jdbcTemplate;

    public ClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Client> getAllClients() {
        return this.jdbcTemplate.query("select * from client", (client,rowNum) ->
        new Client(
                UUID.fromString(client.getString("cl_id")),
                client.getString("cl_firstname"),
                client.getString("cl_lastname"),
                client.getString("cl_dob")));
    }

    @Override
    public Client getClientByID(String cl_id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM client WHERE cl_id = ?", new Object[]{UUID.fromString(cl_id)}, (rs,rowCount)->
                new Client(
                        UUID.fromString(rs.getString("cl_id")),
                        rs.getString("cl_firstname"),
                        rs.getString("cl_lastname"),
                        rs.getString("cl_dob")));
    }

    @Override
    public List<Client> getClientByName(String firstname, String lastname) {
        String sql = "SELECT * FROM client WHERE cl_firstname LIKE '%" + firstname + "%'" + " AND cl_lastname LIKE '%" + lastname + "%'";
        return this.jdbcTemplate.query(sql, (client, rowNum)->
                new Client(
                        UUID.fromString(client.getString("cl_id")),
                        client.getString("cl_firstname"),
                        client.getString("cl_lastname"),
                        client.getString("cl_dob")));
    }

    public List<Client> getClientByName(String name) {
        String sql = "SELECT * FROM client WHERE cl_firstname LIKE '%" + name + "%'" + " OR cl_lastname LIKE '%" + name + "%'";
        return this.jdbcTemplate.query(sql, (client, rowNum)->
                new Client(
                        UUID.fromString(client.getString("cl_id")),
                        client.getString("cl_firstname"),
                        client.getString("cl_lastname"),
                        client.getString("cl_dob")));
    }
    @Override
    public Client getClientAge(String cl_id) {
        return null;
    }

    @Override
    public void addClient(Client client) {
        this.jdbcTemplate.execute("INSERT INTO client (cl_firstname, cl_lastname, cl_dob) VALUES ('"
                + client.getCl_firstname()
                + "', '" + client.getCl_lastname()
                + "', '" + client.getCl_dob()
                + "')"
        );
    }
}
