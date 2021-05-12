package site.yoonsang.practicemvvm2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import site.yoonsang.practicemvvm2.database.TaskDatabase
import site.yoonsang.practicemvvm2.database.TaskEntry
import site.yoonsang.practicemvvm2.repository.TaskRepository

class TaskViewModel(application: Application): AndroidViewModel(application) {

    private val taskDao = TaskDatabase.getDatabase(application).taskDao()
    private val repository: TaskRepository

    val getAllTasks: LiveData<List<TaskEntry>>

    init {
        repository = TaskRepository(taskDao)
        getAllTasks = repository.getAllTasks()
    }

    fun insert(taskEntry: TaskEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(taskEntry)
        }
    }
    fun delete(taskEntry: TaskEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItem(taskEntry)
        }
    }
    fun update(taskEntry: TaskEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateData(taskEntry)
        }
    }
    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }
}