package ir.roela.metro

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import ir.roela.metro.databinding.FragmentMapBinding


class MapFragment : Fragment() {

    private lateinit var mapWebView: WebView

    companion object {
        private lateinit var mapType: MapType

        @JvmStatic
        fun newInstance(mapType: MapType): MapFragment {
            this.mapType = mapType
            return MapFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMapBinding.inflate(LayoutInflater.from(context))
        mapWebView = binding.mapWebView
        mapWebView.settings.setSupportZoom(true)
        mapWebView.settings.builtInZoomControls = true
        mapWebView.settings.displayZoomControls = false
        when (mapType.value) {
            MapType.METRO.value -> {
                loadMap("file:///android_asset/metro.html")
            }
            MapType.BUS.value -> {
                loadMap("file:///android_asset/brt.html")
            }
        }
        return binding.root
    }

    private fun loadMap(url: String) {
        Handler(Looper.getMainLooper()).postDelayed({
            mapWebView.loadUrl(url)
        }, 500)
    }


}