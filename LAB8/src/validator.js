const INVALID = 'invalid';

$.fn.validate = function(regularExpression) {
    return this.each(function () {
        const $element = $(this);
        if (!$element.is('input:text')) {
            throw new Error('Element is not input type text!');
        }
        const inputText = $element.attr('val');
        const checkIsValid = inputText.search(regularExpression);
        checkIsValid > -1 ? $element.removeClass(INVALID) : $element.addClass(INVALID);
    });
};

export default $.fn.validate;
