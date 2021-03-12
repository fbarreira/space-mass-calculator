package com.rox.spacemasscalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var planet:CelestialBodies = CelestialBodies.Moon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
        choosePlanet(CelestialBodies.Moon)
    }

    private fun setListeners(){
        calculateButton.setOnClickListener { calculate() }
    }

    private fun choosePlanet(planet:CelestialBodies){
        this.planet = planet

        when(planet){
            CelestialBodies.Moon -> setPlanet(R.string.how_much_weigh_moon, R.string.your_weight_on_the_moon)
            CelestialBodies.Venus -> setPlanet(R.string.how_much_weigh_venus, R.string.your_weight_on_venus)
            CelestialBodies.Mercury -> setPlanet(R.string.how_much_weigh_mercury, R.string.your_weight_on_mercury)
            CelestialBodies.Mars -> setPlanet(R.string.how_much_weigh_mars, R.string.your_weight_on_mars)
            CelestialBodies.Jupiter -> setPlanet(R.string.how_much_weigh_jupiter, R.string.your_weight_on_jupiter)
            CelestialBodies.Neptune -> setPlanet(R.string.how_much_weigh_neptune, R.string.your_weight_on_neptune)
            CelestialBodies.Saturn -> setPlanet(R.string.how_much_weigh_saturn, R.string.your_weight_on_saturn)
            CelestialBodies.Uranus -> setPlanet(R.string.how_much_weigh_uranus, R.string.your_weight_on_uranus)
            CelestialBodies.Pluto -> setPlanet(R.string.how_much_weigh_pluto, R.string.your_weight_on_pluto)
        }
    }

    private fun setPlanet(keyHowMuch:Int, keyWeightOn:Int){
        titleLabel.text = resources.getString(keyHowMuch)
        weightOnLabel.text = resources.getString(keyWeightOn)
    }

    private fun calculate(){
        val weightEarth = weightInput.text.toString().toFloatOrNull()

        if(weightEarth != null) {
            val weight: Float = (weightEarth / CelestialBodies.Earth.gravForce) * planet.gravForce
            resultText.text = String.format("%.2fKg", weight)
        }
    }
}