package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepository<T> {

    // guardo la clase de la entidad que va a usar el repositorio
    private final Class<T> entityClass;

    // creo el entitymanagerfactory para conectar con la unidad de persistencia
    private final EntityManagerFactory emf;

    // constructor generico
    public BaseRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.emf = Persistence.createEntityManagerFactory("miUnidad");
    }

    // guarda o actualiza una entidad
    public T guardar(T entity) {
        EntityManager em = emf.createEntityManager();

        try {
            // inicio la transaccion
            em.getTransaction().begin();

            // merge sirve para guardar o actualizar
            T entityGuardada = em.merge(entity);

            // confirmo los cambios
            em.getTransaction().commit();

            // devuelvo la entidad guardada
            return entityGuardada;

        } catch (Exception e) {
            // si hay error deshago los cambios
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw e;

        } finally {
            // cierro el entitymanager
            em.close();
        }
    }

    // busca una entidad por id
    public Optional<T> buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();

        try {
            // busco la entidad usando su clase y el id
            T entity = em.find(entityClass, id);

            // si existe devuelve optional con valor y si no existe devuelve empty
            return Optional.ofNullable(entity);

        } finally {
            // cierro el entitymanager
            em.close();
        }
    }

    // lista solo los registros activos
    public List<T> listarActivos() {
        EntityManager em = emf.createEntityManager();

        try {
            // armo la consulta jpql usando el nombre de la clase
            String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e.eliminado = false";

            // creo la consulta tipada
            TypedQuery<T> query = em.createQuery(jpql, entityClass);

            // devuelvo la lista de resultados
            return query.getResultList();

        } finally {
            // cierro el entitymanager
            em.close();
        }
    }

    // realiza baja logica por id
    public boolean eliminarLogico(Long id) {
        EntityManager em = emf.createEntityManager();

        try {
            // inicio la transaccion
            em.getTransaction().begin();

            // busco la entidad
            T entity = em.find(entityClass, id);

            // si no existe devuelvo false
            if (entity == null) {
                return false;
            }

            // cambio eliminado a true usando reflection
            entityClass.getMethod("setEliminado", boolean.class).invoke(entity, true);

            // guardo el cambio
            em.merge(entity);

            // confirmo los cambios
            em.getTransaction().commit();

            return true;

        } catch (Exception e) {
            // si hay error deshago los cambios
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw new RuntimeException(e);

        } finally {
            // cierro el entitymanager
            em.close();
        }
    }
}