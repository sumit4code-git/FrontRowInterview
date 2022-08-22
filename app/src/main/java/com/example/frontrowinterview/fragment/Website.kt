package com.example.frontrowinterview.fragment

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.frontrowinterview.R
import com.example.frontrowinterview.databinding.FragmentWebsiteBinding

class Website : Fragment() {
    private lateinit var binding:FragmentWebsiteBinding
    private val args: WebsiteArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentWebsiteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.web.settings.javaScriptEnabled = true
        binding.web.settings.domStorageEnabled = true
        binding.web.settings.loadWithOverviewMode = true
        var url="https://frontrow.co.in/"
        binding.web.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return true
            }
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                binding.progress.visibility=View.VISIBLE
            }
            override fun onPageFinished(view: WebView?, url: String?) {
                binding.progress.visibility=View.GONE
            }
        }
        binding.web.loadUrl(url)
    }


}
