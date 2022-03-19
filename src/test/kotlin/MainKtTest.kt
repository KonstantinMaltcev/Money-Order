import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun approved_normal_sum_amount_Mastercard_and_Maestro_() {
        // arrange
        val transfer = 585_000_00

        //akt
        val result = amountApproveMastercardMaestro(transfer = transfer)

        //assert
        assertEquals(53000, result)
    }

    @Test
    fun approved_min_sum_amount_Mastercard_and_Maestro_() {
        // arrange
        val transfer = 75_000_00

        //akt
        val result = amountApproveMastercardMaestro(transfer = transfer)

        //assert
        assertEquals(47000, result)
    }

    @Test
    fun approved_not_enough_amount_Mastercard_and_Maestro_() {
        // arrange
        val transfer = 55_000_00

        //akt
        val result = amountApproveMastercardMaestro(transfer = transfer)

        //assert
        assertEquals(0, result)
    }

    @Test
    fun normal_amountApprovedVisaMir() {
        // arrange
        val amount = 41250

        //akt
        val result = amountApprovedVisaMir(amountIntermediate = amount)

        //assert
        assertEquals(41250, result)
    }

    @Test
    fun min_sum_amountApprovedVisaMir() {
        // arrange
        val amount = 3000

        //akt
        val result = amountApprovedVisaMir(amountIntermediate = amount)

        //assert
        assertEquals(3500, result)
    }

    @Test
    fun amount_choice_Maestro() {
        // arrange
        val card = CardName.Maestro
        val mastercardMaestro = 1000
       val visaMir = 2000

        //akt
        val result = amountChoice(userCard = card, amountMastercardMaestro = mastercardMaestro, amountVisaMir = visaMir)

        //assert
        assertEquals(1000, result)
    }

    @Test
    fun amount_choice_Mastercard() {
        // arrange
        val card = CardName.Mastercard
        val mastercardMaestro = 1000
        val visaMir = 2000

        //akt
        val result = amountChoice(userCard = card, amountMastercardMaestro = mastercardMaestro, amountVisaMir = visaMir)

        //assert
        assertEquals(1000, result)
    }

    @Test
    fun amount_choice_VISA() {
        // arrange
        val card = CardName.Visa
        val mastercardMaestro = 1000
        val visaMir = 2000

        //akt
        val result = amountChoice(userCard = card, amountMastercardMaestro = mastercardMaestro, amountVisaMir = visaMir)

        //assert
        assertEquals(2000, result)
    }

    @Test
    fun amount_choice_MIR() {
        // arrange
        val card = CardName.MIR
        val mastercardMaestro = 1000
        val visaMir = 2000

        //akt
        val result = amountChoice(userCard = card, amountMastercardMaestro = mastercardMaestro, amountVisaMir = visaMir)

        //assert
        assertEquals(2000, result)
    }

    @Test
    fun amount_choice_VK_Pay() {
        // arrange
        val card = CardName.VKPay
        val mastercardMaestro = 1000
        val visaMir = 2000

        //akt
        val result = amountChoice(userCard = card, amountMastercardMaestro = mastercardMaestro, amountVisaMir = visaMir)

        //assert
        assertEquals(0, result)
    }

    @Test
    fun cardCheck_Maestro() {
        // arrange
       val card = CardName.Maestro

        //akt
        val result = cardCheck(userCard = card)

        //assert
        assertEquals(600_000_00, result)
    }

    @Test
    fun cardCheck_Mastercard() {
        // arrange
        val card = CardName.Mastercard

        //akt
        val result = cardCheck(userCard = card)

        //assert
        assertEquals(600_000_00, result)
    }

    @Test
    fun cardCheck_MIR() {
        // arrange
        val card = CardName.MIR

        //akt
        val result = cardCheck(userCard = card)

        //assert
        assertEquals(600_000_00, result)
    }

    @Test
    fun cardCheck_VISA() {
        // arrange
        val card = CardName.Visa

        //akt
        val result = cardCheck(userCard = card)

        //assert
        assertEquals(600_000_00, result)
    }

    @Test
    fun cardCheck_VK_Pay() {
        // arrange
        val card = CardName.VKPay

        //akt
        val result = cardCheck(userCard = card)

        //assert
        assertEquals(40_000_00, result)
    }

    @Test
    fun limitOfDay_Maestro() {
        // arrange
        val card = CardName.Maestro

        //akt
        val result = limitOfDay(userCard = card)

        //assert
        assertEquals(150_000_00, result)
    }

    @Test
    fun limitOfDay_Mastercard() {
        // arrange
        val card = CardName.Mastercard

        //akt
        val result = limitOfDay(userCard = card)

        //assert
        assertEquals(150_000_00, result)
    }

    @Test
    fun limitOfDay_MIR() {
        // arrange
        val card = CardName.MIR

        //akt
        val result = limitOfDay(userCard = card)

        //assert
        assertEquals(150_000_00, result)
    }

    @Test
    fun limitOfDay_VISA() {
        // arrange
        val card = CardName.Visa

        //akt
        val result = limitOfDay(userCard = card)

        //assert
        assertEquals(150_000_00, result)
    }

    @Test
    fun limitOfDay_VK_Pay() {
        // arrange
        val card = CardName.VKPay

        //akt
        val result = limitOfDay(userCard = card)

        //assert
        assertEquals(15_000_00, result)
    }

    @Test
    fun month_limit() {
        // arrange
        val transfer = 85_000_00
        val maxTransfer = 75_000_00
        val previousTransfer = 0


        //akt
        val result = dialogueWithTheUser(transfer = transfer, maxTransfer = maxTransfer, previousTransfer = previousTransfer)

        //assert
        assertEquals(0, result)
    }

    @Test
    fun day_limit() {
        // arrange
        val transfer = 65_000_00
        val maxTransfer = 75_000_00
        val previousTransfer = 0

        //akt
        val result = dialogueWithTheUser(transfer = transfer, maxTransfer = maxTransfer, previousTransfer = previousTransfer)

        //assert
        assertEquals(0, result)
    }

    @Test
    fun not_limit() {
        // arrange
        val transfer = 5_000_00
        val maxTransfer = 75_000_00
        val previousTransfer = 0

        //akt
        val result = dialogueWithTheUser(transfer = transfer, maxTransfer = maxTransfer, previousTransfer = previousTransfer)

        //assert
        assertEquals(1, result)
    }

}