/*
 * Copyright (c) 2019 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import exceptions.AliensAttackException
import exceptions.BrokenEngineException
import exceptions.OutOfFuelException
import exceptions.SpaceToEarthConnectionFailedException

class SpaceCraft {

  private var isConnectionAvailable: Boolean = false

  private var isEngineInOrder: Boolean = false

  private var fuel: Int = 0

  var isInSpace: Boolean = false

  fun launch() {
    if (fuel < 5) {
      throw OutOfFuelException()
    }

    if (!isEngineInOrder) {
      throw BrokenEngineException()
    }

    if (!isConnectionAvailable) {
      throw SpaceToEarthConnectionFailedException()
    }

    sendMessageToEarth("Trying to launch...")
    fuel -= 5
    sendMessageToEarth("I'm in space!")
    sendMessageToEarth("I've found some extraterrestrials")
    isInSpace = true
    throw AliensAttackException()
  }

  private fun refuel() {
    fuel += 5
    sendMessageToEarth("The fuel tank is filled")
  }

  fun overhaul() {
    if (fuel < 5) {
      refuel()
    }

    if (!isEngineInOrder) {
      repairEngine()
    }

    if (!isConnectionAvailable) {
      fixConnection()
    }
  }

  private fun repairEngine() {
    isEngineInOrder = true
    sendMessageToEarth("The engine is in order")
  }

  private fun fixConnection() {
    isConnectionAvailable = true
    sendMessageToEarth("Hello Earth! Can you hear me?")
    sendMessageToEarth("Connection is established")
  }

  fun land() {
    sendMessageToEarth("Landing...")
    isInSpace = false
  }

  fun sendMessageToEarth(message: String) = println("Spacecraft to Earth: $message")
}