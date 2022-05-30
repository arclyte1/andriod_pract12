package com.example.pract12

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pract12.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        binding.viewpagerButton.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_imageListFragment)
        }

        binding.gridviewButton.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_gridViewFragment)
        }

        binding.flipCardButton.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_flipCardFragment)
        }

        binding.openGlButton.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_openGLFragment)
        }

    }

}