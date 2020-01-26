describe("validate", () => {
    beforeEach(() => {
        const elem = document.createElement('div');
        elem.id = "mycontainer";
        elem.innerHTML = '<input type="text" id="test" />';
        document.body.appendChild(elem);
    });

    afterEach(() => {
        $('#mycontainer').remove();
    });

    it('search for string in input field and validates it', () => {
        const $test = $('#test');
        $test.attr('val', 'test');
        $test.validate('test');
        expect($test.hasClass('invalid')).toBe(false);
    });

    it('search for regexp in input field and validates it', () => {
        const $test = $('#test');
        $test.attr('val', 'asd');
        $test.validate(/[asd]+/g);
        expect($test.hasClass('invalid')).toBe(false);
    });
    
    it('search for string in input field and invalidates it', () => {
        const $test = $('#test');
        $test.attr('val', 'other');
        $test.validate('test');
        expect($test.hasClass('invalid')).toBe(true);
    });

    it('search for regexp in input field and invalidates it', () => {
        const $test = $('#test');
        $test.attr('val', 'ccc');
        $test.validate(/[asd]+/g);
        expect($test.hasClass('invalid')).toBe(true);
    });

    it('validates invalid element', () => {
        const $test = $('#test');
        $test.addClass('invalid');
        $test.attr('val', 'asd');
        $test.validate(/[asd]+/g);
        expect($test.hasClass('invalid')).toBe(false);
    });

    it('invalidates invalid element', () => {
        const $test = $('#test');
        $test.addClass('invalid');
        $test.attr('val', 'ccc');
        $test.validate(/[asd]+/g);
        expect($test.hasClass('invalid')).toBe(true);
    });

    it('double validates the element', () => {
        const $test = $('#test');
        $test.attr('val', 'asd bbb');
        $test.validate(/[asd]+/g).validate('bbb');
        expect($test.hasClass('invalid')).toBe(false);
    });

    it('throws exception when element is not input', () => {
        const elem = document.createElement('div');
        elem.id = "mycontainer";
        elem.innerHTML = '<span id="superElement">test</span>';
        document.body.appendChild(elem);
        const $superElement = $('#superElement');
        expect(function(){ $superElement.validate(/[asd]+/g); }).toThrow(new Error('Element is not input type text!'));
    });
});