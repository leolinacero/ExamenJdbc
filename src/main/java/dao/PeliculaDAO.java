package dao;

import model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


    public class PeliculaDAO implements DAO<Pelicula> {
        private Connection con;

        public PeliculaDAO(Connection connection) {
            this.con = connection;
        }


        @Override
        public List<Pelicula> findAll() {
            List<Pelicula> peliculas = new ArrayList<>();
            String sql = "SELECT * FROM pelicula";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Pelicula pelicula = new Pelicula(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("genero"),
                            rs.getInt("anho")
                    );
                    peliculas.add(pelicula);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return peliculas;
        }


        @Override
        public Pelicula findById(Integer id) {
            Pelicula pelicula = null;
            String sql = "SELECT * FROM pelicula WHERE id = ?";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    pelicula = new Pelicula(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("genero"),
                            rs.getInt("anho")
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return pelicula;
        }


        @Override
        public void save(Pelicula pelicula) {
            String sql = "INSERT INTO pelicula (titulo, genero, año) VALUES (?, ?, ?)";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, pelicula.getTitulo());
                stmt.setString(2, pelicula.getGenero());
                stmt.setInt(3, pelicula.getAnho());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void update(Pelicula pelicula) {
            String sql = "UPDATE pelicula SET titulo = ?, genero = ?, año = ? WHERE id = ?";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, pelicula.getTitulo());
                stmt.setString(2, pelicula.getGenero());
                stmt.setInt(3, pelicula.getAnho());
                stmt.setInt(4, pelicula.getId());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void delete(int id) {
            String sql = "DELETE FROM pelicula WHERE id = ?";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public List<Pelicula> findByYearRange(int anhoInicio, int anhoFin) {
            List<Pelicula> peliculas = new ArrayList<>();
            String sql = "SELECT * FROM pelicula WHERE año BETWEEN ? AND ?";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, anhoInicio);
                stmt.setInt(2, anhoFin);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Pelicula pelicula = new Pelicula(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("genero"),
                            rs.getInt("anho")
                    );
                    peliculas.add(pelicula);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return peliculas;
        }


        public int countTotalMovies() {
            int total = 0;
            String sql = "SELECT COUNT(*) FROM pelicula";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    total = rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return total;
        }
    }


