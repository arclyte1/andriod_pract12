package com.example.pract12

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pract12.databinding.FragmentFlipCardBinding

class FlipCardFragment : Fragment() {

    private lateinit var binding: FragmentFlipCardBinding
    var isFront = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_flip_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFlipCardBinding.bind(view)

        val front = binding.front
        val back = binding.back
        val frontAnimation = AnimatorInflater.loadAnimator(requireContext(), R.animator.front_animator) as AnimatorSet
        val backAnimation = AnimatorInflater.loadAnimator(requireContext(), R.animator.back_animator) as AnimatorSet

        binding.flip.setOnClickListener {
            if(isFront)
            {
                frontAnimation.setTarget(front);
                backAnimation.setTarget(back);
                frontAnimation.start()
                backAnimation.start()
                isFront = false

            }
            else
            {
                frontAnimation.setTarget(back)
                backAnimation.setTarget(front)
                backAnimation.start()
                frontAnimation.start()
                isFront =true

            }
        }

    }
}