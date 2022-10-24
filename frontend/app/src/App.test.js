import {fireEvent, render, screen} from '@testing-library/react';
import Addition from "./components/Addition";
import {act} from "react-dom/test-utils";
import Soustraction from "./components/Soustraction";

describe('addition tests', () => {
  it('renders right addition', async () => {
    global.fetch = jest.fn().mockImplementation((url) => {
      if (url === "http://localhost:8080/Additionne") {
        return Promise.resolve({
          ok: true,
          json: () => Promise.resolve({result:8})
        });
      } else throw new Error("Bad url call")
    })

    await act(() => {
      render(<Addition/>);

    })
      let numOne = await screen.findByTestId("AddNumOne");
      let numTwo = await screen.findByTestId("AddNumTwo");
      let button = await screen.findByTestId("AddButton");
    await act( async () => {
      fireEvent.change(numOne,{target:{value:4}})
      fireEvent.change(numTwo,{target:{value:4}})
      fireEvent.click(button)
    })
    const result = await screen.getByText(/8/i);
    expect(result).toBeInTheDocument();
    expect(fetch).toBeCalledTimes(1)
  });
  it('addition too big', async () => {
    window.alert = jest.fn()

    global.fetch = jest.fn().mockImplementation((url) => {
      if (url === "http://localhost:8080/Additionne") {
        return Promise.resolve({
          ok: false,
        });
      } else throw new Error("Bad url call")
    })

    await act(() => {
      render(<Addition/>);

    })
      let numOne = await screen.findByTestId("AddNumOne");
      let numTwo = await screen.findByTestId("AddNumTwo");
      let button = await screen.findByTestId("AddButton");
    await act( async () => {
      fireEvent.change(numOne,{target:{value:555555555555555555555555555555555555555555555555555555555555554}})
      fireEvent.change(numTwo,{target:{value:455555555555555555555555555555555555555555555555555555555555555}})
      fireEvent.click(button)
    })
    expect(window.alert).toBeCalledTimes(1)
  });
});

describe('soustraction tests', () => {
  it('renders right soustraction', async () => {
    global.fetch = jest.fn().mockImplementation((url) => {
      if (url === "http://localhost:8080/Soustrait") {
        return Promise.resolve({
          ok: true,
          json: () => Promise.resolve({result:1})
        });
      } else throw new Error("Bad url call")
    })

    await act(() => {
      render(<Soustraction/>);

    })
    let numOne = await screen.findByTestId("SubNumOne");
    let numTwo = await screen.findByTestId("SubNumTwo");
    let button = await screen.findByTestId("SubButton");
    await act( async () => {
      fireEvent.change(numOne,{target:{value:4}})
      fireEvent.change(numTwo,{target:{value:3}})
      fireEvent.click(button)
    })
    const result = await screen.getByText(/1/i);
    expect(result).toBeInTheDocument();
    expect(fetch).toBeCalledTimes(1)
  });
  it('Soustraction too big', async () => {
    window.alert = jest.fn()

    global.fetch = jest.fn().mockImplementation((url) => {
      if (url === "http://localhost:8080/Soustrait") {
        return Promise.resolve({
          ok: false,
        });
      } else throw new Error("Bad url call")
    })

    await act(() => {
      render(<Soustraction/>);

    })
    let numOne = await screen.findByTestId("SubNumOne");
    let numTwo = await screen.findByTestId("SubNumTwo");
    let button = await screen.findByTestId("SubButton");
    await act( async () => {
      fireEvent.change(numOne,{target:{value:555555555555555555555555555555555555555555555555555555555555554}})
      fireEvent.change(numTwo,{target:{value:455555555555555555555555555555555555555555555555555555555555555}})
      fireEvent.click(button)
    })
    expect(window.alert).toBeCalledTimes(1)
  });
});
