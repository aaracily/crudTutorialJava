package com.ara.onetomany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ara.onetomany.model.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo,Long> {
	List<Dojo> findAll();
	 // obtener todos los dojos
    @Query("SELECT d FROM Dojo d")
    List<Dojo> findAllDojos();
    
    // obtener todos los nombre de los dojos.
    @Query("SELECT d.name From Dojo d")
    List<String> findAllDojosNames();
    
    // Pasar parámetros y filtrar (todavía devuelve una lista)
   // @Query("SELECT d FROM Dojo d WHERE id = ?1")
   // List<Dojo> getDojoWhereId(Long id);
    
    // Pasando parámetros y filtrando.
    @Query("SELECT d FROM Dojo d WHERE id = ?1")
    Dojo getSingleDojoWhereId(Long id);
    
    // Observe el tipo int.  Es porque esta función devuelve el número de filas involucradas en la modificación.
    @Modifying
    @Query("update Dojo d set d.name = ?1 WHERE d.id = ?2")
    int setNameForOne(String name, Long id);
    
    @Modifying
    @Query("update Dojo d set d.name = ?1")
    int setNameForAll(String name);
    
    @Modifying
    @Query("delete Dojo d WHERE d.id = ?1")
    int deleteOneDojo(Long id);
 // Seleccionar todo. Obtenemos una lista de objetos Dojo.
    @Query(value="SELECT * from dojos", nativeQuery=true)
    List<Dojo> findAllDojosWithNativeQuery();
    
    // Obtener todos los nombres y el id de los dojos. Si queremos seleccionar una columna específica, obtenemos     una arreglo de objetos porque ya no son objetos Dojos. Cada índice del arreglo será la columna seleccionada      respectivamente, por lo tanto, 0 = columna id, 1 = columna nombre.
    @Query(value="SELECT id, name from dojos", nativeQuery=true)
    List<Object[]> findAllDojosNamesWithId2();
    
    // Obtener un dojo.
    @Query(value="SELECT * FROM dojos WHERE id = ?1", nativeQuery=true)
    Dojo getDojoWhereId(Long id);
}
