package com.example.fragmentlifecycle

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment()
{
    override fun onAttach(context: Context)
    {
        super.onAttach(context)

        println("Lifecycle Blank Fragment - onAttach Invoked")
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        println("Lifecycle Blank Fragment onCreate Invoked")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        println("Lifecycle Blank Fragment - onCreateView Invoked")

        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

        println("Lifecycle Blank Fragment onActivityCreated Invoked")
    }

    override fun onStart()
    {
        super.onStart()

        println("Lifecycle Blank Fragment onStart Invoked")
    }

    override fun onResume()
    {
        super.onResume()

        println("Lifecycle Blank Fragment onResume Invoked")
    }

    override fun onPause()
    {
        super.onPause()

        println("Lifecycle Blank Fragment onPause Invoked")
    }

    override fun onStop()
    {
        super.onStop()

        println("Lifecycle Blank Fragment onStop Invoked")
    }

    override fun onDestroyView()
    {
        super.onDestroyView()

        println("Lifecycle Blank Fragment onDestroyView Invoked")
    }

    override fun onDestroy()
    {
        super.onDestroy()

        println("Lifecycle Blank Fragment onDestroy Invoked")
    }

    override fun onDetach()
    {
        super.onDetach()

        println("Lifecycle Blank Fragment onDetach Invoked")
    }
}