import React from "react";
import axios from "axios";
class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      texts: [],
      id: 0,
      text: "",
      vote: 0,
    };
  }
  componentDidMount() {
    axios.get("http://localhost:8080/api/").then((res) => {
      this.setState({
        texts: res.data,
        id: 0,
        text: "",
        vote: 0,
      });
    });
  }
  submit(evenet, id) {
    console.log(id);
    evenet.preventDefault();
    if (id === 0) {
      axios
        .post("http://localhost:8080/api/", {
          text: this.state.text,
          vote: this.state.vote,
        })
        .then(() => {
          this.componentDidMount();
        });
    } else {
      axios
        .put("http://localhost:8080/api/", {
          id: id,
          text: this.state.text,
          vote: this.state.vote,
        })
        .then(() => {
          this.componentDidMount();
        });
    }
  }
  delete(id) {
    axios.delete("http://localhost:8080/api/" + id).then(() => {
      this.componentDidMount();
    });
  }
  edit(id) {
    axios.get("http://localhost:8080/api/" + id).then((res) => {
      this.setState({
        id: res.data.id,
        text: res.data.text,
        vote: res.data.vote,
      });
    });
  }

  upvote(id) {
    axios.get("http://localhost:8080/api/upvote/" + id).then(() => {
      this.componentDidMount();
    });
  }

  downvote(id) {
    axios.get("http://localhost:8080/api/downvote/" + id).then(() => {
      this.componentDidMount();
    });
  }

  render() {
    return (
      <div className="container">
        <div className="row">
          <div className="col s12">
            <form onSubmit={(e) => this.submit(e, this.state.id)}>
              <div className="row">
                <div className="input-field col s12">
                  <input
                    value={this.state.vote}
                    onChange={(e) => this.setState({ vote: e.target.value })}
                    type="number"
                    hidden
                  />
                </div>
              </div>
              <div className="row">
                <div className="input-field col s12">
                  <textarea
                    value={this.state.text}
                    onChange={(e) => this.setState({ text: e.target.value })}
                    id="textarea1"
                    className="materialize-textarea"
                  ></textarea>
                  <label for="textarea1" class="active">
                    Enter Text
                  </label>
                </div>
              </div>
              <button
                className="btn waves-effect waves-light right"
                type="submit"
                name="action"
              >
                Submit
                <i className="material-icons right">send</i>
              </button>
            </form>
          </div>
        </div>
        <div className="row">
          <div className="col s12">
            <table>
              <tbody>
                {this.state.texts.map((text) => (
                  <tr key={text.id}>
                    <td colspan="2">
                      <p>{text.text}</p>
                    </td>
                    <td width="200">
                      <p>
                        <span class="badge">{text.vote ? text.vote : ""}</span>

                        <button
                          onClick={(e) => this.upvote(text.id)}
                          className="waves-effect waves-light"
                          type="submit"
                          name="action"
                        >
                          <i class="material-icons">thumb_up</i>
                        </button>
                        <button
                          onClick={(e) => this.downvote(text.id)}
                          className="waves-effect waves-light"
                          type="submit"
                          name="action"
                        >
                          <i class="material-icons">thumb_down</i>
                        </button>
                      </p>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    );
  }
}

export default App;
