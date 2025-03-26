package algebra.example.Spring_parcijalniIspist.Polaznik;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PolaznikRowMapper implements RowMapper<Polaznik> {
    @Override
    public Polaznik mapRow(ResultSet rs, int rowNum) throws SQLException{
        Integer id=rs.getInt("id");
        String ime=rs.getString("ime");
        String prezime=rs.getString("prezime");
        return new Polaznik(id,ime,prezime);
    }
}
