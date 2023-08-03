package kityukha.kotlin.countriesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kityukha.kotlin.countriesapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val countryName = binding.countryNameEditText.text.toString()


            lifecycleScope.launch {
                val countries = restCountriesApi.getCountryByName(countryName)
                val country = countries[0]

                binding.countryNameTextView.text = country.name
                binding.capitalTextView.text = country.capital
                binding.populationTextView.text = formatNumber(country.population)
                binding.areaTextView.text = formatNumber(country.area)
                binding.languagesTextView.text = languagesToString(country.languages)
            }
        }
    }
}