/**
 * 
 */
package sample.multimodule.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sample.multimodule.domain.entity.Employee;

/**
 * @author Aife Munshi
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
  
  Employee findById(String id);
  
  @SuppressWarnings("unchecked")
  Employee save(Employee userEntity);

}
