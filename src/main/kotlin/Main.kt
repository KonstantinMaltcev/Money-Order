const val MIN_COMMISSION = 35_00
const val PERCENT_VISA_MIR = 75
const val PERCENT_MAESTRO_MASTERCARD = 60
const val MIN_TRANSFER = 75_000_00
const val MAX_TRANSFER_IN_DAY = 150_000_00
const val MAX_TRANSFER_IN_DAY_VKPAY = 15_000_00
const val MAX_TRANSFER_IN_MONTH = 600_000_00
const val MAX_TRANSFER_IN_MONTH_VKPAY = 40_000_00

enum class CardName {
    Mastercard, Maestro, Visa, Mir, VKPay
}

fun main() {

    println("Добрый день")
    print("Ведите сумму перевода: ")

    val line = readLine()?.toInt()
    val transfer = line!!.times(100)
    val userCard = CardName.Mir
    val maxTransfer = cardCheck(userCard)

    val coefficient = dialogueWithTheUser(transfer, maxTransfer)
    val amountIntermediate = transfer / 10000 * PERCENT_VISA_MIR
    val amountVisaMir = amountApprovedVisaMir(amountIntermediate)
    val amountMastercardMaestro = amountApproveMastercardMaestro(transfer)
    val amount = amountChoice(userCard, amountMastercardMaestro, amountVisaMir)
    printResult(transfer, amount, coefficient)


}

fun amountApproveMastercardMaestro(transfer: Int) =
    if (transfer >= MIN_TRANSFER) (transfer / 10000 * PERCENT_MAESTRO_MASTERCARD) + 20_00 else 0

fun amountApprovedVisaMir(amountIntermediate: Int) =
    if (amountIntermediate > MIN_COMMISSION) amountIntermediate else MIN_COMMISSION

fun amountChoice(
    userCard: CardName,
    amountMastercardMaestro: Int,
    amountVisaMir: Int
) = when (userCard) {
    CardName.Mastercard, CardName.Maestro -> amountMastercardMaestro
    CardName.Mir, CardName.Visa -> amountVisaMir
    CardName.VKPay -> 0
}

fun cardCheck(userCard: CardName = CardName.VKPay) = when (userCard) {
    CardName.Mastercard, CardName.Maestro, CardName.Mir, CardName.Visa -> MAX_TRANSFER_IN_MONTH
    CardName.VKPay -> MAX_TRANSFER_IN_MONTH_VKPAY
}

fun limitOfDay(userCard: CardName = CardName.VKPay) = when (userCard) {
    CardName.Mastercard, CardName.Maestro, CardName.Mir, CardName.Visa -> MAX_TRANSFER_IN_DAY
    CardName.VKPay -> MAX_TRANSFER_IN_DAY_VKPAY
}

fun dialogueWithTheUser(
    transfer: Int,
    maxTransfer: Int,
    previousTransfer: Int = 0,
): Int {
    return when {
        transfer >= (maxTransfer - previousTransfer) -> {
            println("Вы превысили лимит переводов в этом месяце")
            0
        }
        transfer >= limitOfDay() -> {
            println("Вы превысили лимит переводов сегодня")
            0
        }
        else -> 1
    }
}

fun printResult(
    transfer: Int,
    amount: Int,
    coefficient: Int,
) {
    if (transfer >= 0) {
        println("Сумма вашего перевода: ${(transfer / 100.00) * coefficient} рублей")
        println("Комиссия за перевод составит: ${(amount / 100.00) * coefficient} рублей")
        print("Итого: ${(transfer + amount) / 100.00} рублей")
    } else println("Попробуйте войти заново и ввести положительную сумму")
    println("До свидания!")
}

