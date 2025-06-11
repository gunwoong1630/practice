package org.example.validation

import org.springframework.stereotype.Repository

@Repository
class MemoryRepository {
    final val store: MutableMap<Long, SomeEntity> = mutableMapOf()
    final var sequence: Long = 0

    fun save(entity: SomeEntity) {
        entity.id = sequence++
        store[entity.id] = entity
    }

    fun findById(id: Long): SomeEntity =
        store.getOrElse(id) { throw IllegalArgumentException("Entity with id $id not found") }

    fun findAll(): List<SomeEntity> = store.values.toList()

    fun remove(id: Long) = store.remove(id)

    fun update(entity: SomeEntity) = store.put(entity.id, entity)

}
