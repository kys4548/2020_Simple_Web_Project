const React = require("react");
const { Component } = React;

function getNumbers() {
  // 숫자 네 개를 겹치지 않고 랜덤하게 뽑는 함수
}

class NumberBaseball extends Component {
  state = {
    result: "",
    value: "",
    answer: getNumbers(),
    tries: [],
  };

  onSubmitForm = () => {};

  onChangeInput = (e) => {
    this.setState({
      value: e.target.value,
    });
  };

  render() {
    return (
      <>
        <h1>{this.state.result}</h1>
        <form onSubmit={this.onSubmitForm}>
          <input
            maxLength={4}
            value={this.state.value}
            onChange={this.onChangeInput}
          />
          <button type="submit">제출</button>
        </form>
        <div>시도 : {this.state.tries.length}</div>
        <ul>
          {["like", "like", "like", "like", "like"].map((s) => {
            return <li>{s}</li>;
          })}
        </ul>
      </>
    );
  }
}

module.exports = NumberBaseball;
