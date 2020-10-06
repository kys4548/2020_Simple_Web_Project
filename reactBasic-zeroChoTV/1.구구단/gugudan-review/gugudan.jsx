const React = require("react");
const { useState, useRef, Fragment } = React;

const GuGuDan = () => {
  const [first, setFirst] = useState(Math.ceil(Math.random() * 9));
  const [second, setSecond] = useState(Math.ceil(Math.random() * 9));
  const [value, setValue] = useState("");
  const [result, SetResult] = useState("");
  const inputRef = useRef();

  onChange = (e) => {
    setValue(e.target.value);
  };

  onSubmit = (e) => {
    e.preventDefault();
    if (parseInt(value) === first * second) {
      setFirst(Math.ceil(Math.random() * 9));
      setSecond(Math.ceil(Math.random() * 9));
      setResult("정답 : " + value);
    } else {
      setResult("땡!");
    }
    setValue("");
    inputRef.current.focus();
  };

  return (
    <Fragment>
      <div>
        {first} 곱하기 {second} 는 ?
      </div>
      <form onSubmit={onSubmit}>
        <input ref={inputRef} onChange={onChange} type="number" value={value} />
        <button type="submit">제출</button>
      </form>
      <div>{result}</div>
    </Fragment>
  );
};

module.exports = GuGuDan;
