package autest.autest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import autest.autest.entities.Operator;

public interface OperatorRepository extends JpaRepository<Operator, Long>
{
    
}
