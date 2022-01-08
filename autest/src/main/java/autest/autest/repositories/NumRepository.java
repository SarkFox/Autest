package autest.autest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import autest.autest.entities.Num;

public interface NumRepository extends JpaRepository<Num, Long>
{
    
}
