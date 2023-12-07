import { Hello } from "../app/hello";
import { expect } from "chai";

describe('Hello', () => {

    it('shouldGreet', () => {
        const hello = new Hello();

        const greeting = hello.greeting();

        expect(greeting).to.equal("Hello World");
    });

});
