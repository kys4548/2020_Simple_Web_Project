const React = require("react");
const ReactDom = require("React-dom");

const GuGuDan = require("./gugudan");

ReactDom.render(
  <>
    <GuGuDan />
    <GuGuDan />
    <GuGuDan />
    <GuGuDan />
    <GuGuDan />
  </>,
  document.querySelector("#root")
);
