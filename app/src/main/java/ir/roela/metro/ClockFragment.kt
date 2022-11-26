package ir.roela.metro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.roela.metro.databinding.FragmentClockBinding

class ClockFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance(): ClockFragment {
            return ClockFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentClockBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }

}
