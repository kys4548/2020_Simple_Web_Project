const React = require("react");
const { useState, useRef } = React;

const WordRelay = () => {
  
    const [word, setWord] = useState("카페베네");
    const [vlaue, setValue] = useState("");
    const [result, setResult] = useState("");
    const inputRef = useRef(null);

  const onChange = (e) => {
      setValue(e.target.value)
  };

  const onSubmit = (e) => {
    e.preventDefault();
    if (
      word[word.length - 1] === value.charAt(0)
    ) {
      setResult("통과 : " + word);
      setWord(value);
    } else {
      setResult("실패 : " + value);
    }
    setValue("");
    inputRef.current.focus();
  };

  render() {
    return (
      <>
        <div>{word}</div>
        <form onSubmit={onSubmit}>
          <input
            ref={inputRef}
            onChange={onChange}
            type="text"
            value={value}
          />
          <button type="submit">제출</button>
        </form>
        <div>{result}</div>
      </>
    );
  }
}

module.exports = WordRelay;
