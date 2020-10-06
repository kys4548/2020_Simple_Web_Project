const React = require("react");
const ReactDom = require("react-dom");

const { hot } = require("react-hot-loader/root");

const Sample = require("./Sample");

const Hot = hot(Sample);

ReactDom.render(<Hot />, document.querySelector("#root"));
