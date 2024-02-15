package ru.career.guidance.business.callback;

/**
 * Типы callback
 */
public enum CallbackAnswerType {

    LIKE(2),

    DONT_KNOW(1),

    DOUBT(0),

    DONT_LIKE(-1),

    REALLY_DONT_LIKE(-2),

    /**
     * Неизвестный тип
     */
    UNKNOWN(0);

    private Integer score;

    CallbackAnswerType(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public static CallbackAnswerType fromValue(String callbackRaw) {
        for (CallbackAnswerType callbackAnswerType : values()) {
            if (callbackRaw.contains(callbackAnswerType.name())) {
                return callbackAnswerType;
            }
        }

        return UNKNOWN;
    }
}
