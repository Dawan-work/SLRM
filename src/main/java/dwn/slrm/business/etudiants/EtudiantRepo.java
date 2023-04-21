package dwn.slrm.business.etudiants;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
    @Modifying
    @Query("UPDATE Etudiant e SET e.active = false WHERE e.id = :id")
    void deleteById(@NonNull Long id);

    Optional<Etudiant> findByNomAndPrenom(String nom, String prenom);
}
