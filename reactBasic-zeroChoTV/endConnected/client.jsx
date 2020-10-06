// java script extend
// 리액트 전용파일임을 인지하는데 도움

const React = require("react");
const ReactDom = require("react-dom");

const WordRelay = require("./WordRelay");

ReactDom.render(<WordRelay />, document.querySelector("#root"));
