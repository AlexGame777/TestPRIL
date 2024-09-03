package com.example.testpril.back
import com.example.testpril.model.Cell
import com.example.testpril.model.Life
import kotlin.random.Random




    fun add(cells:MutableList<Any>){
        val newCell:Cell
        val RandomValue = Random.nextBoolean()
        if (RandomValue) {
            newCell = Cell(IS_Alive = true)
        }else{
            newCell = Cell(IS_Alive = false)
        }
        cells.add(newCell)
        CheckLifeRulus(cells)
    }

    fun CheckLifeRulus(cells: MutableList<Any>){
        if (cells.size >= 3){
            val lastTreeCells = cells.takeLast(3).filterIsInstance<Cell>()
            if (lastTreeCells.size == 3){
                val alliveCount = lastTreeCells.count{it.IS_Alive}
                if (alliveCount == 3){
                    cells.add(Life())
                }else if (alliveCount == 0){
                    val LastLifeIndex = cells.indexOfLast { it is Life }
                    if(LastLifeIndex != -1){
                        cells.removeAt(LastLifeIndex)
                    }
                }
            }

        }
    }
