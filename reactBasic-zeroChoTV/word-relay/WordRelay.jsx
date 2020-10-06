const React = require("react");
const { Component } = React;

class WordRelay extends Component {
  state = {
    word: "카페베네",
    vlaue: "",
    result: "",
  };

  onChange = (e) => {
    this.setState({
      value: e.target.value,
    });
  };

  onSubmit = (e) => {
    e.preventDefault();
    if (
      this.state.word[this.state.word.length - 1] === this.state.value.charAt(0)
    ) {
      this.setState((prevState) => {
        return {
          word: prevState.value,
          value: "",
          result: "통과",
        };
      });
    } else {
      this.setState((prevState) => {
        return {
          value: "",
          result: "실패 : " + prevState.value,
        };
      });
    }
  };

  input;

  onRef = (c) => (input = c);

  render() {
    return (
      <>
        <div>{this.state.word}</div>
        <form onSubmit={this.onSubmit}>
          <input
            ref={this.onRef}
            onChange={this.onChange}
            type="text"
            value={this.state.value}
          />
          <button type="submit">제출</button>
        </form>
        <div>{this.state.result}</div>
      </>
    );
  }
}

module.exports = WordRelay;
