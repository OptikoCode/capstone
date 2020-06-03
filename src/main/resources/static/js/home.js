// HOME PAGE JS AND GSAP

const content = document.querySelector(".content");
const left = document.querySelector(".left");
const right = document.querySelector(".right");

left.addEventListener('mouseenter', () => {
    content.classList.add('hover-left');
});

left.addEventListener('mouseleave', () => {
    content.classList.remove('hover-left');
});

right.addEventListener('mouseenter', () => {
    content.classList.add('hover-right');
});

right.addEventListener('mouseleave', () => {
    content.classList.remove('hover-right');
});


let leftHomeDiv = new TimelineMax();
leftHomeDiv.from("#left", 2, {
    delay: 0.1,
    opacity: 0,
    x: -103,
    ease: Expo.ease
}).from("#left", 2, {
    delay: 0.1,
    opacity: 0,
    x: -103,
    ease: Expo.ease
}, "-=5");

let rightHomeDiv = new TimelineMax();
rightHomeDiv.from("#right", 2, {
    delay: 0.1,
    opacity: 0,
    x: 103,
    ease: Expo.ease
}).from("#right", 2, {
    delay: 0.1,
    opacity: 0,
    x: 103,
    ease: Expo.ease
}, "-=5");


let lettersAndButton = new TimelineMax();
lettersAndButton.from("#home-o-letter", 1, { //will need to be id on home page
    delay: 0.77,
    opacity: 0,
    x: -70,
    ease: Expo.easeOut
}).from(".home-button", 1, {
    delay: 0.77,
    opacity: 0,
    y: -70,
    ease: Expo.easeOut
}).from("#home-c-letter", 1, {
    delay: 0.77,
    opacity: 0,
    x: 70,
    ease: Expo.easeOut
}), "-=5";

let leftPara = new TimelineMax();

leftPara.from(".left-home-para", 2, {
    delay: 2.61,
    opacity: 0,
    y: 20,
    ease: Expo.easeIn
}).from(".left-home-para", 2, {
    delay: 2.61,
    opacity: 0,
    y: 20,
    ease: Expo.easeIn
}, "-=5");

let rightPara = new TimelineMax();

rightPara.from(".right-home-para", 2, {
    delay: 2.61,
    opacity: 0,
    y: 20,
    ease: Expo.easeIn
}).from(".right-home-para", 2, {
    delay: 2.61,
    opacity: 0,
    y: 20,
    ease: Expo.easeIn
}, "-=5");