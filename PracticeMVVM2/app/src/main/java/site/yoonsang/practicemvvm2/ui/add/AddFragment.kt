package site.yoonsang.practicemvvm2.ui.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import site.yoonsang.practicemvvm2.R
import site.yoonsang.practicemvvm2.database.TaskEntry
import site.yoonsang.practicemvvm2.databinding.FragmentAddBinding
import site.yoonsang.practicemvvm2.viewmodel.TaskViewModel

class AddFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentAddBinding.inflate(inflater)

        val myAdapter = ArrayAdapter<String>(
            requireActivity(),
            R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.priorities)
        )
        binding.apply {
            spinner.adapter = myAdapter
            btnAdd.setOnClickListener {
                if (TextUtils.isEmpty(editTask.text)) {
                    Toast.makeText(requireContext(), "It's empty", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val titleStr = editTask.text.toString()
                val priority = spinner.selectedItemPosition

                val taskEntry = TaskEntry(
                    0,
                    titleStr,
                    priority,
                    System.currentTimeMillis()
                )

                viewModel.insert(taskEntry)
                Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_addFragment_to_taskFragment)
            }
        }
        return binding.root
    }
}