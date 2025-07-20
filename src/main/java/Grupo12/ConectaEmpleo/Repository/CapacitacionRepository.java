/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo12.ConectaEmpleo.Repository;

/**
 *
 * @author Home
 */
import Grupo12.ConectaEmpleo.Model.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapacitacionRepository extends JpaRepository<Capacitacion, Long> {
    
}
