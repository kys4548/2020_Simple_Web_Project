const React = require("react");
const { Component } = React;

class WordRelay extends Component {
  state = {
    text: "반복",
  };

  render() {
    return <React.Fragment>{this.state.text}</React.Fragment>;
  }
}

module.exports = WordRelay;
